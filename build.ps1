# Set JAVA_HOME to Android Studio's bundled JDK
$env:JAVA_HOME = "C:\Program Files\Android\Android Studio\jbr"

# Verify JAVA_HOME is set correctly
Write-Host "JAVA_HOME is set to: $env:JAVA_HOME"

# Clean and build the project
Write-Host "Cleaning project..."
.\gradlew clean --no-daemon

if ($LASTEXITCODE -eq 0) {
    Write-Host "Clean successful. Building project..."
    .\gradlew build --no-daemon
} else {
    Write-Host "Clean failed. Exiting."
    exit 1
}
