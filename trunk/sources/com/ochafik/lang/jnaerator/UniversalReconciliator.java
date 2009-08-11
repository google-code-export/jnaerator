package com.ochafik.lang.jnaerator;

import static com.ochafik.lang.jnaerator.parser.ElementsHelper.typeRef;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ochafik.lang.jnaerator.parser.Declarator;
import com.ochafik.lang.jnaerator.parser.Scanner;
import com.ochafik.lang.jnaerator.parser.TypeRef;
import com.ochafik.lang.jnaerator.parser.TypeRef.SimpleTypeRef;
import com.ochafik.util.listenable.Pair;

public class UniversalReconciliator {

	
	static class DefSeq {
		List<SimpleTypeRef> simpleTypeRefs = new ArrayList<SimpleTypeRef>();
//		List<Identifier> identifiers = new ArrayList<Identifier>();
		List<Declarator> declarators = new ArrayList<Declarator>();
		boolean matches(DefSeq o) {
			int n = declarators.size();
			if (n != declarators.size())
				return false;
			if (simpleTypeRefs.size() != o.simpleTypeRefs.size())
				return false;
			for (int i = 0; i < n; i++) {
				Declarator id = declarators.get(i), oid = declarators.get(i);
				if (!id.toString().equals(oid.toString()))
					return false;
			}
			return true;
		}
	}
	DefSeq extractDefSeq(TypeRef tr) {
		final DefSeq ret = new DefSeq();
		tr.accept(new Scanner() {
			@Override
			public void visitDeclarator(Declarator declarator) {
				super.visitDeclarator(declarator);
				ret.declarators.add(declarator);
			}
//			public void visitIdentifier(Identifier i) {
//				super.visitIdentifier(i);
//				ret.identifiers.add(i);
//			}
			@Override
			public void visitSimpleTypeRef(SimpleTypeRef simpleTypeRef) {
				super.visitSimpleTypeRef(simpleTypeRef);
				ret.simpleTypeRefs.add(simpleTypeRef);
			}
		});
		return ret;
	}
	public static class ReconciliationException extends Exception {
		private static final long serialVersionUID = -8197343041734256268L;
		public ReconciliationException(TypeRef t1, TypeRef t2, TypeRef reason1, TypeRef reason2) {
			this(t1, t2, "\"" + reason1 + "\" and \"" + reason2 + "\" cannot be matched");
		}
		public ReconciliationException(TypeRef t1, TypeRef t2, String reason) {
			super("Types \"" + t1 + "\" and \"" + t2 + "\" could not be reconciliated" + (reason == null ? "" : ". Reason = " + reason));
		}
	}
	public TypeRef reconciliate32bitsAnd64bits(TypeRef tr32, TypeRef tr64) throws ReconciliationException {
		if (tr32 == null && tr64 == null)
			return null;
		if ((tr32 == null) != (tr64 == null)) {
			if (tr32 == null && tr64.toString().matches("id") ||
					tr64 == null && tr32.toString().equals("id"))
				return typeRef("id");
			throw new ReconciliationException(tr32, tr64, null);
		}
		
		tr32 = tr32.clone();
		DefSeq s32 = extractDefSeq(tr32), s64 = extractDefSeq(tr64);
		if (!s32.matches(s64))
			throw new ReconciliationException(tr32, tr64, null);
		
		int n = s32.simpleTypeRefs.size();
		for (int i = 0; i < n; i++) {
			TypeRef.SimpleTypeRef t32 = s32.simpleTypeRefs.get(i), t64 = s64.simpleTypeRefs.get(i);
			if (t32.toString().equals(t64.toString()))
				continue;
			TypeRef.SimpleTypeRef tr = reconciliateSimple32bitsAnd64bits(t32, t64);
			if (tr == null)
				throw new ReconciliationException(tr32, tr64, t32, t64);
			t32.replaceBy(tr);
		}
		// TODO Auto-generated method stub
		return tr32;
	}

	static Map<Pair<String, String>, String> predefined32_64Reconciliations = new HashMap<Pair<String,String>, String>();
	static {
		defRecon("float", "double", "CGFloat");
		defRecon("long", "long long", "long");
		defRecon("int", "long long", "int");
		defRecon("unsigned long", "unsigned long long", "unsigned long");
		defRecon("unsigned int", "unsigned long long", "unsigned int");
		defRecon("signed long", "signed long long", "signed long");
		defRecon("signed int", "signed long long", "signed int");
	}
	static void defRecon(String s32, String s64, String sRecon) {
		predefined32_64Reconciliations.put(new Pair<String, String>(s32, s64), sRecon);
	}
	public static SimpleTypeRef reconciliateSimple32bitsAnd64bits(SimpleTypeRef t32, SimpleTypeRef t64) {
		String recon = predefined32_64Reconciliations.get(new Pair<String, String>(t32.toString(), t64.toString()));
		
		return typeRef(recon);
	}

}
