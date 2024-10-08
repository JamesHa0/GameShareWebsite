<template>
    <div class="footer">
		<div class="translate">
			<div class="footer-links">
				<h5>官方网站</h5>
				<ul>
					<li><a href="https://store.steampowered.com">steam官网</a></li>
					<li><a href="https://www.epicgames.com/site/zh-CN/home">Epic官网</a></li>
					<li><a href="https://www.origin.com">Origin官网</a></li>
					<li><a href="https://www.ubisoft.com/zh-tw">Ubisoft官网</a></li>
					<li><a href="https://www.wegame.com.cn">Wegame官网</a></li>
				</ul>
			</div>
			<div class="footer-links">
				<h5>游戏攻略</h5>
				<ul>
					<li><a href="https://www.3dmgame.com">3DM游戏网站</a></li>
					<li><a href="https://www.gamersky.com">游民星空</a></li>
					<li><a href="https://www.ucg.cn">游戏机实用技术</a></li>
					<li><a href="https://www.vgtime.com">游戏时光</a></li>
					<li><a href="https://nga.178.com">NGA</a></li>
					<li><a href="https://gl.ali213.net">游侠攻略</a></li>
				</ul>
			</div>
			<div class="footer-links">
				<h5>游戏MOD</h5>
				<ul>
					<li><a href="https://www.nexusmods.com">Nexus Mods</a></li>
					<li><a href="https://steamcommunity.com/workshop">steam创意工坊</a></li>
					<li><a href="https://mod.3dmgame.com">3DM Mod站</a></li>
					<li><a href="https://down.gamersky.com/oth/mod">游民星空下载站</a></li>
					<li><a href="https://patch.ali213.net/">游侠补丁</a></li>
				</ul>
			</div>
		</div>
	</div>
</template>

<script>
export default {

}
</script>

<style>
.footer {
	height: 350px;
	background-color: #e5e8e0;
	margin-top: 20px;
	display: block;
	overflow: hidden;	/* 清除浮动 */
}

.translate {
	width: 1300px;
	margin: 0 auto;
	padding-top: 40px;
}

.footer-links {
	float: left;
	width: 160px;
	margin-left: 200px;
}

.footer-links h5 {
	font-size: 20px;
	margin-bottom: 30px;
}

.footer-links li {
	font-size: 15px;
	margin-top: 15px;
}

.footer-links li a {
	color: #3d3d3d;
}

.footer-links li a:hover {
	color: #ea822e;
}

</style>