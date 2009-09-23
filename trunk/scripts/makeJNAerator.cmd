mvn -f jnaerator-runtime/pom.xml clean deploy && mvn "-Dstorepass=$KEYSTORE_PASS" -f jnaerator/pom.xml clean package jar:sign deploy:deploy
