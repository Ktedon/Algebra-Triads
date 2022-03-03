module.exports = {
  "require": (function(x0) {
    return {
      "react-dom": require("react-dom"),
      "resources/index.css": require("resources/index.css"),
      "resources/bootstrap.css": require("resources/bootstrap.css"),
      "react": require("react"),
      "react-proxy": require("react-proxy")
    }[x0]
  })
}