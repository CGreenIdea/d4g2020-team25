/* JS parsing, enhancement and compression */
import babel from "@rollup/plugin-babel";
import { terser } from "rollup-plugin-terser";

/* Determine whether this production mode */
// `npm run build` -> `production` is true
// `npm run start` -> `production` is false
const production = !process.env.ROLLUP_WATCH;

export default {
    input: 'src/js/index.js',

    output: {
        name: 'ifn',
        dir: 'dist/js',
        entryFileNames: '[name].[hash].js',
        // immediately-invoked function expression — suitable for <script> tags
        format: 'iife'
    },

    plugins: [
        /* JS transformation */
        // Transpile ES6/7 to browser-compatible OS
        babel({ babelHelpers: 'bundled' }),

        // Minify, but only in production mode
        production && terser(),
    ],
};
