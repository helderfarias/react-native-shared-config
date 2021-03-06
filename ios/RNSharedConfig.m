
#import "RNSharedConfig.h"
#import "PDKeychainBindings.h"

@implementation RNSharedConfig

RCT_EXPORT_MODULE()

RCT_EXPORT_METHOD(setItem:(NSString *)key value:(NSString *)newValue resolver:(RCTPromiseResolveBlock)resolve rejecter:(RCTPromiseRejectBlock)reject)
{
    [[PDKeychainBindings sharedKeychainBindings] setString:newValue forKey:key];
    
    resolve(@"true");
}

RCT_EXPORT_METHOD(getItem:(NSString *)key resolver:(RCTPromiseResolveBlock)resolve rejecter:(RCTPromiseRejectBlock)reject)
{
    NSString *value = [[PDKeychainBindings sharedKeychainBindings] stringForKey:key];
    if (value == nil) {
        resolve(@"");
        return;
    }
    
    resolve(value);
}

RCT_EXPORT_METHOD(removeItem:(NSString *)key resolver:(RCTPromiseResolveBlock)resolve rejecter:(RCTPromiseRejectBlock)reject)
{
    [[PDKeychainBindings sharedKeychainBindings] removeObjectForKey:key];
    
    resolve(@"true");
}

@end
  
