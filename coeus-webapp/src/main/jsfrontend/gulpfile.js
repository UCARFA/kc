/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
var gulp = require('gulp');
var aglio = require('gulp-aglio');
var gutil = require('gulp-util');
var rename = require('gulp-rename');
var webpack = require('webpack');
var WebpackDevServer = require('webpack-dev-server');
var webpackConfig = require('./webpack.config.js')(process.env);


var dest = process.env.OVERRIDE_DEST || '../../../target/generated-web-sources/jsfrontend-web-sources';
webpackConfig.output.path = dest + '/client/assets/';

gulp.task('docs', function () {
  gulp.src('apidocs/*.md')
    .pipe(aglio({ template: 'default', themeFullWidth: true, includePath : process.cwd() + '/apidocs/' }))
    .pipe(gulp.dest(dest + '/apidocs'));
  gulp.src('apidocs/index.html')
    .pipe(gulp.dest(dest + '/apidocs'));
});

gulp.task('webpack', function (callback) {
	var localWebpackConfig = Object.create(webpackConfig);
	localWebpackConfig.plugins = localWebpackConfig.plugins || [ ];
	localWebpackConfig.plugins = localWebpackConfig.plugins.concat(
		new webpack.DefinePlugin({
			"process.env" : { "NODE_ENV" : JSON.stringify("production") }
		}),
		new webpack.optimize.DedupePlugin(),
		new webpack.optimize.UglifyJsPlugin()
	);

	webpack(localWebpackConfig, function(err, stats) {
		if (err) throw new gutil.PluginError("webpack", err);
		gutil.log("[webpack]", stats.toString({ colors: true }));
		callback();
	});
});

gulp.task('static-assets', function() {
	gulp.src('client/**/*.html').pipe(gulp.dest(dest + '/WEB-INF/client/'));
	gulp.src('client/**/*').pipe(gulp.dest(dest + '/client/'));
});

gulp.task('clients', ['webpack', 'static-assets']);

gulp.task('dev-build', ['static-assets','webpack:build-dev'], function() {
	gulp.watch(['instituteRates/**/*', 'client/**/*'], ['static-assets', 'webpack:build-dev']);
});

gulp.task('default', ['docs', 'clients']);
