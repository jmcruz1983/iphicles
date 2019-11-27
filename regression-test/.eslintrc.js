module.exports = {
    "parserOptions": {
      "ecmaVersion": 8
    },
    "env": {
        "es6": true,
        "node": true,
        "mocha": true
    },
    "extends": "eslint:recommended",
    "rules": {
        "indent": [
            2,
            2
        ],
        "linebreak-style": [
            2,
            "unix"
        ],
        "quotes": [
            2,
            "single"
        ],
        "semi": [
            2,
            "never"
        ],
        "no-console": 0,
        "complexity": ["error", { "max": 5 }]
    }
};
