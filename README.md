# GoogleFormHandler

Works synchronously.

## Installation

To use the library, first include it your project using Gradle


    allprojects {
        repositories {
            jcenter()
            maven { url "https://jitpack.io" }
        }
    }

	dependencies {
	        compile 'com.github.mkaflowski:GoogleFormHandler:v1.0.5'
	}
	
##ProGuard

If you are using ProGuard you might need to add the following option:
```
-keepattributes Signature
-keepattributes Annotation
-keep class okhttp3.** { *; }
-keep interface okhttp3.** { *; }
-dontwarn okhttp3.**
-dontwarn okio.**
```

## How to use

Calling varargs methods:

```java
        FormHandler formHandler = FormHandler.getInstance();
        formHandler.setActionURL("https://docs.google.com/forms/d/e/1FAIpQLSckxYU7gI1B8bZzWQvGe7Vk6Lb6Uko1fF8l_ryKL52TVJUzLw/formResponse");
        formHandler.setEntries("entry.714513599", "entry.7145135955", "entry.714513599");
        formHandler.setValues("One", "Two", "Three");
        formHandler.post();
```

or

```java
        FormHandler formHandler = FormHandler.getInstance();
        formHandler.setListener(new FormHandler.FormHandlerListener() {
            @Override
            public void onPostComplete() {
                Log.i("TAG","complete");
            }

            @Override
            public void onPostError() {
                Log.i("TAG","complete");
            }
        });
        formHandler.post("https://docs.google.com/forms/d/e/1FAIpQLSckxYU7gI1B8bZzWQvGe7Vk6Lb6Uko1fF8l_ryKL52TVJUzLw/formResponse", "entry.714513099", getPackageName());
```
