<template>
  <!--搜索框-->
	<div class="search-bar">
		<input type="text" class="text">
		<button>
			<img src="../../assets/images/search.png" width="40px">
		</button>
	</div>
</template>

<script>
export default {

}
</script>

<style>
/****************<!--搜索框-->***************/
.search-bar {
    position: relative;
    height: 60px;
    margin: 20px auto 0;
    width: 500px;
    height: 45px;
    border: 2px solid #f53c66;
}
.search-bar .text{
    width: 400px;
    height: 37px;
    border: none;
    padding: 4px 10px 0;
    outline: none;
}
.search-bar button{
    float: right;
    border: none;
    width: 80px;
    height: 100%;
    background-color: #f53c3c;
    cursor: pointer;
}


</style>