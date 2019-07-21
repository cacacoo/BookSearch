import Action from './actions'

const ActionCreator = {
	loadData(data) {
		return { type: Action.LOAD_DATA,
				value: { data }
			};
	},

	changeValue(id, value) {
		return { type:Action.CHANGE_VALUE,
				value: {id, value}
			};
	}
};


const Service = (dispatch) => ({
	loadData(data) {
		return dispatch(ActionCreator.loadData(data));
	},
	changeValue(coinId, value) {
		return dispatch(ActionCreator.changeValue(coinId, value));
	},
});

export default Service;