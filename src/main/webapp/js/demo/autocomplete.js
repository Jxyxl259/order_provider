function dataFn(input) {
    var data = [{"value":"121","xxx":"121","yyy":"yyy"},
            {"value":"122","xxx":"122","yyy":"yyy"},
            {"value":"123","xxx":"123","yyy":"yyy"},
            {"value":"124","xxx":"124","yyy":"yyy"},
            {"value":"125","xxx":"125","yyy":"yyy"},
            {"value":"126","xxx":"126","yyy":"yyy"},
            {"value":"127","xxx":"127","yyy":"yyy"},
            {"value":"128","xxx":"128","yyy":"yyy"},
            {"value":"129","xxx":"129","yyy":"yyy"},
            {"value":"220","xxx":"220","yyy":"yyy"},
            {"value":"221","xxx":"221","yyy":"yyy"}];
    return data;
};

function valueFn(item) {
    return item["value"];
}

function labelFn(item) {
    return item["value"] + "-" + item["yyy"];
}

function selectFn(item) {
    alert(valueFn(item));
}

var data = dataFn();