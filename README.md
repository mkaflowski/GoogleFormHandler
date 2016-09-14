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
	        compile 'com.github.mkaflowski:GoogleFormHandler:v1.0.2'
	}

## How to use

Calling vargs methods:

```java
        FormHandler formHandler = FormHandler.getInstance();
        formHandler.setURL("https://docs.google.com/forms/d/e/1FAIpQLSckxYU7gI1B8bZzWQvGe7Vk6Lb6Uko1fF8l_ryKL52TVJUzLw/formResponse");
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
