mvn -f jnaerator-runtime/pom.xml clean deploy install && mvn "-Dstorepass=$KEYSTORE_PASS" -f jnaerator/pom.xml clean package jar:sign deploy:deploy site-deploy
