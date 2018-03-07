var exec = require('cordova/exec');

exports.find = function(successCallback, errorCallback) {
    cordova.exec(successCallback, errorCallback, 'ZebraWiFiPrinter', 'find', []);
};

