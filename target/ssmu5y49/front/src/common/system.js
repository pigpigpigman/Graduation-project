export function isAuth(tableName, key) {
  let role = localStorage.getItem("UserTableName");
  let menus = [{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-full","buttons":["new","view","edit","delete"],"menu":" user ","menuJump":"列表","tableName":"yonghu"}],"menu":" user MGT"},{"child":[{"appFrontIcon":"cuIcon-cardboard","buttons":["new","view","edit","delete"],"menu":"Music classification","menuJump":"列表","tableName":"yinlefenlei"}],"menu":"Music classification MGT"},{"child":[{"appFrontIcon":"cuIcon-pic","buttons":["new","view","edit","delete","view review"],"menu":"Singer INFO","menuJump":"列表","tableName":"geshouxinxi"}],"menu":"Singer INFO MGT"},{"child":[{"appFrontIcon":"cuIcon-rank","buttons":["new","view","edit","delete","view review"],"menu":"Song INFO","menuJump":"列表","tableName":"gequxinxi"}],"menu":"Song INFO MGT"},{"child":[{"appFrontIcon":"cuIcon-attentionfavor","buttons":["new","view","edit","delete","view review"],"menu":"Music album","menuJump":"列表","tableName":"yinlezhuanji"}],"menu":"Music album MGT"},{"child":[{"appFrontIcon":"cuIcon-time","buttons":["new","view","edit","delete","view review"],"menu":"Music MV","menuJump":"列表","tableName":"yinlemv"}],"menu":"Music MV MGT"},{"child":[{"appFrontIcon":"cuIcon-keyboard","buttons":["view","edit","delete","view review"],"menu":"Music review INFO","menuJump":"列表","tableName":"lepingxinxi"}],"menu":"Music review INFO MGT"},{"child":[{"appFrontIcon":"cuIcon-goods","buttons":["new","view","edit","delete","view review"],"menu":"Music charts","menuJump":"列表","tableName":"yinlebangdan"}],"menu":"Music charts MGT"},{"child":[{"appFrontIcon":"cuIcon-discover","buttons":["new","view","edit","delete","view review"],"menu":"Annual list","menuJump":"列表","tableName":"niandubangdan"}],"menu":"Annual list MGT"},{"child":[{"appFrontIcon":"cuIcon-service","buttons":["new","view","edit","delete"],"menu":"Help center","tableName":"chat"},{"appFrontIcon":"cuIcon-rank","buttons":["new","view","edit","delete"],"menu":"Rotation chart MGT","tableName":"config"},{"appFrontIcon":"cuIcon-news","buttons":["new","view","edit","delete"],"menu":"Music INFO","tableName":"news"}],"menu":"System MGT"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-flashlightopen","buttons":["view"],"menu":"Singer INFO列表","menuJump":"列表","tableName":"geshouxinxi"}],"menu":"Singer INFO模块"},{"child":[{"appFrontIcon":"cuIcon-addressbook","buttons":["view"],"menu":"Song INFO列表","menuJump":"列表","tableName":"gequxinxi"}],"menu":"Song INFO模块"},{"child":[{"appFrontIcon":"cuIcon-full","buttons":["view","Music criticism"],"menu":"Music album列表","menuJump":"列表","tableName":"yinlezhuanji"}],"menu":"Music album模块"},{"child":[{"appFrontIcon":"cuIcon-copy","buttons":["view"],"menu":"Music MV列表","menuJump":"列表","tableName":"yinlemv"}],"menu":"Music MV模块"},{"child":[{"appFrontIcon":"cuIcon-skin","buttons":["view"],"menu":"Music review INFO列表","menuJump":"列表","tableName":"lepingxinxi"}],"menu":"Music review INFO模块"},{"child":[{"appFrontIcon":"cuIcon-full","buttons":["view"],"menu":"Music charts列表","menuJump":"列表","tableName":"yinlebangdan"}],"menu":"Music charts模块"},{"child":[{"appFrontIcon":"cuIcon-send","buttons":["view"],"menu":"Annual list列表","menuJump":"列表","tableName":"niandubangdan"}],"menu":"Annual list模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"否","hasFrontRegister":"否","roleName":"Administrator ","tableName":"users"},{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-keyboard","buttons":["view","edit","delete","view review"],"menu":"Music review INFO","menuJump":"列表","tableName":"lepingxinxi"}],"menu":"Music review INFO MGT"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-flashlightopen","buttons":["view"],"menu":"Singer INFO列表","menuJump":"列表","tableName":"geshouxinxi"}],"menu":"Singer INFO模块"},{"child":[{"appFrontIcon":"cuIcon-addressbook","buttons":["view"],"menu":"Song INFO列表","menuJump":"列表","tableName":"gequxinxi"}],"menu":"Song INFO模块"},{"child":[{"appFrontIcon":"cuIcon-full","buttons":["view","Music criticism"],"menu":"Music album列表","menuJump":"列表","tableName":"yinlezhuanji"}],"menu":"Music album模块"},{"child":[{"appFrontIcon":"cuIcon-copy","buttons":["view"],"menu":"Music MV列表","menuJump":"列表","tableName":"yinlemv"}],"menu":"Music MV模块"},{"child":[{"appFrontIcon":"cuIcon-skin","buttons":["view"],"menu":"Music review INFO列表","menuJump":"列表","tableName":"lepingxinxi"}],"menu":"Music review INFO模块"},{"child":[{"appFrontIcon":"cuIcon-full","buttons":["view"],"menu":"Music charts列表","menuJump":"列表","tableName":"yinlebangdan"}],"menu":"Music charts模块"},{"child":[{"appFrontIcon":"cuIcon-send","buttons":["view"],"menu":"Annual list列表","menuJump":"列表","tableName":"niandubangdan"}],"menu":"Annual list模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"是","hasFrontRegister":"是","roleName":" user ","tableName":"yonghu"}];
  for(let i=0;i<menus.length;i++){
    if(menus[i].tableName==role){
      for(let j=0;j<menus[i].frontMenu.length;j++){
          for(let k=0;k<menus[i].frontMenu[j].child.length;k++){
            if(tableName==menus[i].frontMenu[j].child[k].tableName){
              let buttons = menus[i].frontMenu[j].child[k].buttons.join(',');
              return buttons.indexOf(key) !== -1 || false
            }
          }
      }
    }
  }
  return false;
}

/**
 *  * 获取当前时间（yyyy-MM-dd hh:mm:ss）
 *   */
export function getCurDateTime() {
    let currentTime = new Date(),
    year = currentTime.getFullYear(),
    month = currentTime.getMonth() + 1 < 10 ? '0' + (currentTime.getMonth() + 1) : currentTime.getMonth() + 1,
    day = currentTime.getDate() < 10 ? '0' + currentTime.getDate() : currentTime.getDate(),
    hour = currentTime.getHours(),
    minute = currentTime.getMinutes(),
    second = currentTime.getSeconds();
    return year + "-" + month + "-" + day + " " +hour +":" +minute+":"+second;
}

/**
 *  * 获取当前日期（yyyy-MM-dd）
 *   */
export function getCurDate() {
    let currentTime = new Date(),
    year = currentTime.getFullYear(),
    month = currentTime.getMonth() + 1 < 10 ? '0' + (currentTime.getMonth() + 1) : currentTime.getMonth() + 1,
    day = currentTime.getDate() < 10 ? '0' + currentTime.getDate() : currentTime.getDate();
    return year + "-" + month + "-" + day;
}
