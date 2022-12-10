var replace = require('replace-in-file');
var buildVersion = process.argv[2];
const version = {
    files: 'src/info.json',
    from: /"version":"(\w|\d|-|\.)+"/gm,
    to: "\"version\":\""+ buildVersion + "\"",
    allowEmptyPaths: false,
};

const date = {
    files: 'src/info.json',
	from: /"build\.date":"(\w|\d|:| |-|\)|\()+"/gm,
    to: "\"build.date\":\""+ new Date() + "\"",
    allowEmptyPaths: false,
};

try {
    let changedFiles = replace.sync(version);
	changedFiles = replace.sync(date);
    console.log('Build version set: ' + buildVersion);
}
catch (error) {
    console.error('Error occurred:', error);
    throw error
}