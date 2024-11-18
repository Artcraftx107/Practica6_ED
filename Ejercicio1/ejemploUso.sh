#!/bin/sh

javac -d bin --source-path src:test src/EjemploUso.java
java -cp bin EjemploUso

