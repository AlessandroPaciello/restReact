const { src, dest, series, parallel } = require('gulp');
const del = require('del');
const log = require('fancy-log');
const path = require('path');

const paths = {
    react_src: path.join(__dirname, '/build/**/*'),
    react_dist: path.join(__dirname, '../webapp/static/')
};

function clean()  {
    log('removing the old files in the directory')
    return del(path.join(__dirname, '../webapp/static/**'), {force:true});
}

function copyReactCodeTask() {
    log(paths.react_dist)
    return src(paths.react_src)
        .pipe(dest(paths.react_dist));
}

exports.build = series(
    clean,
    copyReactCodeTask
);