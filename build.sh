#!/bin/bash

set -e

if ! command -v docker &> /dev/null/; then
    echo "Docker is not installed, Please install Docker and try again."
    exit 1
fi

echo "Docker is installed. Continuing build..."

REPO_URL="https://github.com/jason-erasmus/java_binarytree.git"
CLONE_DIR="app-temp"

echo "Cloning the repository..."
rm -rf $CLONE_DIR
git clone $REPO_URL $CLONE_DIR

cd $CLONE_DIR

echo "Building Docker image..."
docker docker build -t binarytree-app .

echo "Launching Java Binary Tree..."
docker docker run --rm binarytree-app


