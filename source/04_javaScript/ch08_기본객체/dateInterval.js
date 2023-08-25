Date.prototype.getIntervalDay = function(that){
    //now.getIntervalDay(openday) : now는 this가 , openday는 taht
    // if(this >that){
    //     var intervarMilliSec = this.getTime() - that.getTime();
    // }else{
    //     var intervarMilliSec = this.getTime() - this.getTime();
    // }
    var intervarMilliSec = Math.abs(this.getTime() - that.getTime());
    let day = Math.trunc(intervarMilliSec/ (1000*60*60*24));
    return day;
}
// let now = new Date();
// let openday = new Date(2023,5,26,9,30,0);
// console.log('now ~ openday 날짜 :' + now.getIntervalDay(openday)+'일<br>');
// console.log('now ~ openday 날짜 :' + openday.getIntervalDay(now)+'일<br>');
