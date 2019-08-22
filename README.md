# OrientationDetector

*`OrientationDetector`* is a well-documented android library, a high-level library that makes detecting the orientation of the device easy and still leaving you with the flexibility to use it where needed.

## Installation

### Step 1. Add the JitPack repository to your build file



```
allprojects {
     repositories {
	      ...
	      maven { url 'https://jitpack.io' }
     }
}
```

### Step 2. Add the dependency




```
dependencies {
	  implementation 'com.github.MoustafaElsaghier:OrientationDetector:0.1.0'
}
```


## Usage
1- Create a new Instance of `OrientationDetector`
```
OrientationDetector detector;
```
2- in `onCreate()` method init it :
```
detector = new OrientationDetector(this);
```
3- in `onStart()` method enable the listner :

```
@Override
protected void onStart() {
    super.onStart();
    detector.enable();
}
```
4- in `onStop()` method disable the listner :

```
@Override
protected void onStop() {
    super.onStop();
    detector.disable();
}
```
### To get the orientation of the device just use `detector` object :
```
// true  if portraits, false in landscape
boolean isPortraite = detector.isPortrait();
```

### in case you need to know the degree of rotation :
```java
/* 0 for portrait
 * 180 for reverse-portrait
 * 90 for landscape
 * 270 for reverse-landscape
*/
int rotateValue = detector.getRotateValue();
```
### Hint : never try to get the values in `onCreate()`
## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.
