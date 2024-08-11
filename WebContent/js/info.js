/******通过权重随机生成分数 */
function generateWeightedScore() {
  // 分数及其对应的权重
  const scores = [
    { point: 0, weight: 10 },
    { point: 1, weight: 200 },
    { point: 2, weight: 500 },
    { point: 3, weight: 500 },
    { point: 4, weight: 400 },
    { point: 5, weight: 300 },
    { point: 6, weight: 100 },
    { point: 10, weight: 20 },
    { point: 15, weight: 10 },
    { point: 20, weight: 5 },
    { point: 100, weight: 1 }
  ];
  
  // 计算总权重
  const totalWeight = scores.reduce((acc, score) => acc + score.weight, 0);

  // 生成一个0到总权重的随机数
  const random = Math.random() * totalWeight;
  
  let cumulativeWeight = 0; // 累积权重
  for (const score of scores) {
    cumulativeWeight += score.weight;
    if (random < cumulativeWeight) {
      return score.point;
    }
  }
  // 极端情况，返回最后一个分数
  return scores[scores.length - 1].point;
}

function testDraws(numDraws = 10000000) {
  const results = {};
  for (let i = 0; i < numDraws; i++) {
    const point = generateWeightedScore();
    if (results[point]) {
      results[point] += 1;
    } else {
      results[point] = 1;
    }
  }
  // 计算并显示百分比
  for (const point in results) {
    const percentage = (results[point] / numDraws * 100).toFixed(2); // 计算百分比并保留两位小数
    console.log(`点数 ${point}: ${percentage}%`);
  }
}


/*创建dialog弹窗*/
function createDialog(message,color) {
	if(message==undefined)message='默认消息';
	if(color==undefined)color='#ffffff';
	//生成容器：
    const Div_container = document.createElement('div');	//造元素
    Div_container.id = 'dialog';	//写id名
	//生成内容：
    Div_container.innerHTML = `
        <p style="color:${color}">${message}</p>
    `;
	
    Div_container.style.display = "block";	//显示弹窗
    let body=document.getElementsByTagName('body')[0];
    body.appendChild(Div_container)
    setTimeout(function() {
            Div_container.style.display = "none";
    }, 4000); // 等待动画完成后彻底隐藏弹窗
}


/*************************************************业务函数： */
/*签到处理函数*/
function click_checkin(Info_user){
	let Span_pointNum=document.querySelector('.pointNum');
	const nowTimestamp = Date.now();	//当前时间戳
	const daysSince1980 = Math.floor(nowTimestamp / 86400000);// 将毫秒差转换为天数（一天有86400000毫秒）
	let checkin_at=localStorage.getItem('checkin_at')
	if(checkin_at==daysSince1980){
		createDialog('今天已签到，明天再来哦','#ffffff');
		return;
	}
	document.querySelector('#loadingFrame').style.display="block";	//小猪loading显示
	const point=generateWeightedScore();
	
	let urlSearchParams=new URLSearchParams();
	urlSearchParams.append('uid',Info_user.uid)
	urlSearchParams.append('uname',Info_user.uname)
	urlSearchParams.append('utel',Info_user.utel)
	urlSearchParams.append('uemail',Info_user.uemail)
	urlSearchParams.append('urole',Info_user.urole)
	urlSearchParams.append('ugender',Info_user.ugender)
	urlSearchParams.append('uaddress',Info_user.uaddress)
	urlSearchParams.append('upsw',Info_user.upsw)
	urlSearchParams.append('upoint',parseInt(Span_pointNum.textContent) + parseInt(point))	//点数更新
console.debug(Info_user)
	fetch('UpdateUserServlet.do',{
		method:'POST',
		headers:{
			'Content-Type':'application/x-www-form-urlencoded'
		},
		body:urlSearchParams
	})
	.then(response=>{
		if(!response.ok){
			throw new Error('操作失败')
		}else{
			console.debug('操作成功')
		}
	})
	.then(()=>{	//操作成功，更新页面显示
		Span_pointNum.textContent = urlSearchParams.get('upoint');	//数值更新
        Span_pointNum.style.color = '#cc6600'; // 更新样式
        
        localStorage.setItem('checkin_at',daysSince1980)	//存入本地存储
        
        createDialog(`恭喜获得${point}积分`,`#ffffff`);	//弹窗提示
	})
	.catch(error=>{
		alert('签到入库时出现异常：'+error.message)
	})
	.finally(()=>{
		document.querySelector('#loadingFrame')
			.style.display = "none"; // 隐藏小猪loading
	})
	
}