var gulp = require("gulp");
var jshint = require("gulp-jshint");
var clean = require('gulp-clean');
var concat = require('gulp-concat');
var uglify = require('gulp-uglify');
var es = require('event-stream');
var htmlmin = require('gulp-htmlmin');
var cleancss = require('gulp-cleancss');
var runSequence = require("run-sequence");
var rename = require("gulp-rename");
var nodemon = require('gulp-nodemon');
var spawn   = require('child_process');
var bs = require('browser-sync');
var reload = bs.reload;
var gnf = require('gulp-npm-files');


gulp.task("clean",function(){
    return gulp.src("target/")
            .pipe(clean());
});

gulp.task("jshint",function(){
    return gulp.src("js/**/*.js")
            .pipe(jshint())
            .pipe(jshint.reporter("default"));
});

//gulp.task("uglify",["clean"],function(){
//    return es.merge([
//            gulp.src(["node_modules/angular/angular.min.js",
//                      "node_modules/angular-messages/angular-messages.min.js"]),
//            gulp.src(["lib/**/*.js",
//                      "js/**/*.js"]).pipe(concat("scripts.js")).pipe(uglify())
//            ])
//            .pipe(concat("scripts.min.js"))
//            .pipe(gulp.dest("target/observerguice/js"));
//});

gulp.task("jsmin",[],function(){
return gulp.src("js/**/*")
      .pipe(gulp.dest("target/observerguice/js"));
});


gulp.task("viewhtmlmin",function(){
    return gulp.src(["view/**/*.html"])
            .pipe(htmlmin({collapseWhitespace:true}))
            .pipe(gulp.dest("target/observerguice/view"));
});

gulp.task("parthtmlmin",function(){
    return gulp.src(["partials/**/*.html"])
            .pipe(htmlmin({collapseWhitespace:true}))
            .pipe(gulp.dest("target/observerguice/partials"));
});

gulp.task("cssmin",function(){
    return gulp.src(["css/**/*.css"])
            .pipe(cleancss())
            //.pipe(concat("styles.min.css"))
            .pipe(gulp.dest("target/observerguice/css"));
});

//Exemplo de uso da copia
//gulp.task("copy",function(){
//    return gulp.src("view/prototipo.html")
//            .pipe(rename("prototype.html"))
//            .pipe(gulp.dest("dist/"));
//});





gulp.task('copyNpmDependenciesAtDifferentFolder', function() {
	  gulp
	    .src(gnf(null, 'package.json'), {base:'./'})
	    .pipe(gulp.dest('./target/observerguice'));
	});


gulp.task("default",[],function(){
    return runSequence('clean',['copyNpmDependenciesAtDifferentFolder','viewhtmlmin','cssmin','jsmin','parthtmlmin']);
});

