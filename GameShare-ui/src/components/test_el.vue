<template><!-- 同上 -->
  <form>


  </form>

</template>

<style scoped>
.comment-container {
  width: 100%;
  max-width: 500px;
  margin: 20px auto;
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 8px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  background-color: #fff;
  display: flex;
  flex-direction: column;
}

.comment-box {
  width: 100%;
  min-height: 100px;
  padding: 10px;
  margin-bottom: 10px;
  border: 1px solid #ccc;
  border-radius: 4px;
  font-size: 14px;
  box-sizing: border-box;
  overflow-y: auto;
}

.comment-box[contenteditable="true"]:empty:before {
  content: attr(placeholder);
  color: #aaa;
  display: block;
}

.submit-button {
  align-self: flex-end;
  padding: 8px 16px;
  font-size: 14px;
  border: none;
  border-radius: 4px;
  background-color: #007bff;
  color: white;
  cursor: pointer;
  transition: background-color 0.3s ease;
}

.submit-button:hover {
  background-color: #0056b3;
}

</style>
