import Mock from 'mockjs'

Mock.mock('http://localhost:5173/game','get',{
    'data2': {
        'mtime':'@datetime',
        'score|1-800':800
    }
})