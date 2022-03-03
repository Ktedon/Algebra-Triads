if (process.env.NODE_ENV === "production") {
    const opt = require("./triad1-opt.js");
    opt.main();
    module.exports = opt;
} else {
    var exports = window;
    exports.require = require("./triad1-fastopt-entrypoint.js").require;
    window.global = window;

    const fastOpt = require("./triad1-fastopt.js");
    fastOpt.main()
    module.exports = fastOpt;

    if (module.hot) {
        module.hot.accept();
    }
}
