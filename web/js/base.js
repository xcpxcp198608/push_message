/**
 * Created by xuchengpeng on 08/05/2017.
 */
function $ (eId) {
    return document.getElementById(eId)
}

function getXmlRequest() {
    var xmlHttpRequest;
    if(window.XMLHttpRequest){
        xmlHttpRequest = new XMLHttpRequest();
    }else{
        xmlHttpRequest = new ActiveXObject("Microsoft.XMLHTTP");
    }
    return xmlHttpRequest;
}