./gradlew clean
./gradlew assembleDebug
adb install -r app/build/outputs/apk/debug/*.apk
