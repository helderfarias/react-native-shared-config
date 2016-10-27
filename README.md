
# react-native-shared-config

## Getting started

`$ npm install react-native-shared-config --save` 
or 
`$ yarn add react-native-shared-config` 

### Mostly automatic installation

`$ react-native link react-native-shared-config`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-shared-config` and add `RNSharedConfig.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNSharedConfig.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import br.com.helderfarias.sharedconfig.RNSharedConfigPackage;` to the imports at the top of the file
  - Add `new RNSharedConfigPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-shared-config'
  	project(':react-native-shared-config').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-shared-config/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-shared-config')
  	```


## Usage
```javascript
import RNSharedConfig from 'react-native-shared-config';

// TODO: What do with the module?
RNSharedConfig.setItem('token', '5829c3a5-e93d-4758-95da-cc23501a2d3a');

RNSharedConfig.getItem('token').then((t) => console.log(t));

RNSharedConfig.removeItem('token');
```
  
