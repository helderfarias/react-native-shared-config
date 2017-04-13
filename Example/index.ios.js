/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 * @flow
 */

import React, { Component } from "react";
import { AppRegistry, StyleSheet, Text, View } from "react-native";
import SharedConfig from 'react-native-shared-config';

export default class Example extends Component {

  async componentWillMount() {
    await SharedConfig.setItem('token', '5829c3a5-e93d-4758-95da-cc23501a2d3a');
    await SharedConfig.getItem('token').then(token => console.log(token));
    await SharedConfig.removeItem('token');
    await SharedConfig.getItem('token-not-found').then(token => console.log('Empty: ', token));
  }

  render() {
    return (
      <View style={styles.container}>
        <Text style={styles.welcome}>
          Welcome to React Native!
        </Text>
        <Text style={styles.instructions}>
          To get started, edit index.ios.js
        </Text>
        <Text style={styles.instructions}>
          Press Cmd+R to reload,{"\n"}
          Cmd+D or shake for dev menu
        </Text>
      </View>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: "center",
    alignItems: "center",
    backgroundColor: "#F5FCFF"
  },
  welcome: {
    fontSize: 20,
    textAlign: "center",
    margin: 10
  },
  instructions: {
    textAlign: "center",
    color: "#333333",
    marginBottom: 5
  }
});

AppRegistry.registerComponent("Example", () => Example);
