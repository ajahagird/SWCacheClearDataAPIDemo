
This example intends to demo handling of webview clearCache API with CacheStorage. Demo has two components
1. https://massive-delirious-wish.glitch.me installs Service Worker on the load.
2. Android App that loads this URL in a WebView.

### Steps
1. Open App. If you do not see `true` for both CacheStorage and WebCache when loaded, then restart the app. Ensure both are `true` before proceeding.
2. CacheStorage is populated using [CacheStorage](https://developer.mozilla.org/en-US/docs/Web/API/CacheStorage) apis by service worker during installation & is available to pages using windows.caches object. WebCache is populated by browser when it downloads any cacheable HTTP resource. In our case, it is cacheable [sample.css](https://massive-delirious-wish.glitch.me/sample.css) referenced by the browser. There is no way to access WebCache directly, so we rely on performance timing api's [transferSize](https://developer.mozilla.org/en-US/docs/Web/API/PerformanceResourceTiming/transferSize) as an heuristic to detect that it loaded from the cache.
3.  Click on Clear WebView. It will reload the page. It will execute both [WebStorage.html#deleteAllData](https://developer.android.com/reference/android/webkit/WebStorage.html#deleteAllData()) and [WebView#clearCache](https://developer.android.com/reference/android/webkit/WebView#clearCache(boolean)). This implementation is present in [MainActivity](app/src/main/java/com/example/swcachecleardataapidemo/MainActivity.java).

### Analysis
Observe that, after reload, CacheStorage continues to pass data presence check where as WebCache doesn't.