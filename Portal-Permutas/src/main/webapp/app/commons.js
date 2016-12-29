"use strict";
function showLoading() {
    console.log("loading ...");
}
exports.showLoading = showLoading;
function hideLoading() {
    console.log("loaded");
}
exports.hideLoading = hideLoading;
function doNothing() { }
exports.doNothing = doNothing;
exports.webServiceEndpoint = 'http://localhost:8080/api';
//# sourceMappingURL=commons.js.map