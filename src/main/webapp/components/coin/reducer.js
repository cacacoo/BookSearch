import Actions from "./actions";

const Reducer = (state = {}, action) => {
	switch (action.type) {
		case Actions.LOAD_DATA:
			const { data } = action.value;
			let datas = {};
			data.forEach(coin => {
				datas[coin.coinId] = coin;
			});
			return Object.assign({}, state, { coins: datas });

		case Actions.CHANGE_VALUE:
			const { id, value } = action.value;
			const { coins } = state;
			const coin = Object.assign({}, coins[id], {coinValue: value});
			const newCoins = Object.assign({}, coins, { coin });
			return Object.assign({}, state, { coins: newCoins});
		default:
			return state;
	}
};

export default Reducer;