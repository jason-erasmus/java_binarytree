
$ErrorActionPreference = "Stop"

# Check for Docker
if (-not (Get-Command docker -ErrorAction SilentlyContinue)) {
    Write-Host "Docker is not installed. Please install Docker and try again."
    exit 1
}

Write-Host "Docker is installed. Continuing build..."

$REPO_URL = "https://github.com/jason-erasmus/java_binarytree.git"
$CLONE_DIR = "app-temp"

Write-Host "Cloning the repository..."
if (Test-Path $CLONE_DIR) {
    Remove-Item -Recurse -Force $CLONE_DIR
}
git clone $REPO_URL $CLONE_DIR

Set-Location $CLONE_DIR

Write-Host "Building Docker image..."
docker build -t binarytree-app .

Write-Host "Launching Java Binary Tree..."
docker run --rm binarytree-app
