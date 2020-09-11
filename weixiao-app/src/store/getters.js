const getters = {
  id: state => state.user.id,
  token: state => state.user.token,
  truename: state => state.user.truename,
  nickname: state => state.user.nickname,
  faceImgMin: state => state.user.faceImgMin,
  number: state => state.user.number,
  phone: state => state.user.phone,
  sex: state => state.user.sex,
  age: state => state.user.age,
  areaName: state => state.user.area,
  areaId: state => state.user.areaId,
  academyId: state => state.user.academyId,
  autograph: state => state.user.autograph,
  hide: state => state.user.hide,
  websocket: state => state.user.websocket
}
export default getters
