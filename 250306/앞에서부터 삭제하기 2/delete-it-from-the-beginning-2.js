const fs = require("fs");
const input = fs.readFileSync(0).toString().trim().split('\n');

const n = Number(input[0]);
const arr = input[1].split(' ').map(Number);
let result=0
for(let k=1; k<=n-2; k++){
    const newArray=arr.slice(k)
    newArray.sort((a,b)=>a-b)
    newArray.shift()
    const sum=newArray.reduce((cur,i)=>cur+=i,0)
    result=Math.max(result,(sum/newArray.length))

}
console.log(result.toFixed(2))