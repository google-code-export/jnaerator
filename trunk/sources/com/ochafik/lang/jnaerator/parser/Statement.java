/*
	Copyright (c) 2009 Olivier Chafik, All Rights Reserved
	
	This file is part of JNAerator (http://jnaerator.googlecode.com/).
	
	JNAerator is free software: you can redistribute it and/or modify
	it under the terms of the GNU General Public License as published by
	the Free Software Foundation, either version 3 of the License, or
	(at your option) any later version.
	
	JNAerator is distributed in the hope that it will be useful,
	but WITHOUT ANY WARRANTY; without even the implied warranty of
	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
	GNU General Public License for more details.
	
	You should have received a copy of the GNU General Public License
	along with JNAerator.  If not, see <http://www.gnu.org/licenses/>.
*/
package com.ochafik.lang.jnaerator.parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Statement extends Element {
	public static class ExpressionStatement extends Statement {

		public ExpressionStatement() {}
		public ExpressionStatement(Expression expression) {
			setExpression(expression);
		}

		Expression expression;
		
		public Expression getExpression() {
			return expression;
		}
		public void setExpression(Expression expression) {
			this.expression = changeValue(this, this.expression, expression);
		}
		
		@Override
		public void accept(Visitor visitor) {
			visitor.visitExpressionStatement(this);
		}

		@Override
		public Element getNextChild(Element child) {
			return null;
		}

		@Override
		public Element getPreviousChild(Element child) {
			return null;
		}

		@Override
		public boolean replaceChild(Element child, Element by) {
			if (getExpression() == child) {
				setExpression((Expression)by);
				return true;
			}
			return false;
		}

		@Override
		public String toString(CharSequence indent) {
			return expression == null ? null : expression.toString(indent) + ";";
		}
		
	}
	
	public static class Block extends Statement {
		final List<Statement> statements = new ArrayList<Statement>();
		@Override
		public void accept(Visitor visitor) {
			visitor.visitBlock(this);
		}

		
		public Block() {}
		public Block(Statement... statements) {
			setStatements(statements);
		}
		public void setStatements(List<Statement> statements) {
			changeValue(this, this.statements, statements);
		}
		public void setStatements(Statement... statements) {
			setStatements(Arrays.asList(statements));
		}
		public List<Statement> getStatements() {
			return unmodifiableList(statements);
		}
		@Override
		public Element getNextChild(Element child) {
			return getNextSibling(statements, child);
		}

		@Override
		public Element getPreviousChild(Element child) {
			return getPreviousSibling(statements, child);
		}

		@Override
		public boolean replaceChild(Element child, Element by) {
			return replaceChild(statements, Statement.class, this, child, by);
		}

		@Override
		public String toString(CharSequence indent) {
			StringBuilder b = new StringBuilder();
			b.append('{');
			if (!statements.isEmpty()) {
				String nindent = indent + "\t";
				String lnindent = "\n" + nindent;
				b.append(lnindent);
				b.append(implode(statements, lnindent, nindent));
				b.append('\n');
				b.append(indent);
			}
			b.append('}');
			return b.toString();
		}

	}
}
