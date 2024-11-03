#!/bin/bash
#!/bin/bash

# Asegúrate de que JAVA_HOME esté configurado
export JAVA_HOME=/usr/lib/jvm/java-17-openjdk
export PATH=$JAVA_HOME/bin:$PATH

# Compilar tu aplicación
./gradlew build
