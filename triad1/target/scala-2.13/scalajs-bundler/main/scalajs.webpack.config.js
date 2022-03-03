module.exports = {
  "entry": {
    "triad1-fastopt": ["/home/bradly/Desktop/triad/triad1/target/scala-2.13/scalajs-bundler/main/triad1-fastopt-entrypoint.js"]
  },
  "output": {
    "path": "/home/bradly/Desktop/triad/triad1/target/scala-2.13/scalajs-bundler/main",
    "filename": "[name]-library.js",
    "library": "ScalaJSBundlerLibrary",
    "libraryTarget": "var"
  },
  "mode": "development",
  "devtool": "source-map",
  "module": {
    "rules": [{
      "test": new RegExp("\\.js$"),
      "enforce": "pre",
      "use": ["source-map-loader"]
    }]
  }
}