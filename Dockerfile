FROM openjdk:17-slim

WORKDIR /app

COPY src/ ./src/

RUN javac src/BinaryTree.java

CMD ["java","-cp", "src" ,"BinaryTree"]