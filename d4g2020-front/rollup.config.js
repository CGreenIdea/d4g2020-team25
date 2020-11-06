/* Node resolution */
import json from '@rollup/plugin-json';
import resolve from '@rollup/plugin-node-resolve';
import commonjs from '@rollup/plugin-commonjs';

/* Node utilities */
import path from 'path';

/* JS parsing, enhancement and compression */
import babel from '@rollup/plugin-babel';
import { terser } from 'rollup-plugin-terser';

/* Environment */
import inject from '@rollup/plugin-inject';

/* Determine whether this production mode */
// `npm run build` -> `production` is true
// `npm run start` -> `production` is false
const production = !process.env.ROLLUP_WATCH;

export default {
    input: 'src/js/index.js',

    output: {
        //name: 'ifn',
        dir: 'dist',
        //entryFileNames: 'ifn.[hash].js',
        entryFileNames: 'ifn.js',
        // immediately-invoked function expression — suitable for <script> tags
        format: 'iife'
    },

    plugins: [
        /* Node resolution */
        // transform Node dependencies so that Rollup can process them
        json(),
        resolve(),
        commonjs(), // converts node modules to ES modules

        /* JS transformation */
        // Inject environment variables
        inject({
            env: path.resolve(production ? 'env/prod.js' : 'env/dev.js')
        }),

        // Transpile ES6/7 to browser-compatible OS
        babel({ babelHelpers: 'bundled' }),

        // Minify, but only in production mode
        production && terser()
    ],
};
