import Action from './actions'
import { search } from './domain'

const ActionCreator = {
	updateCondition(condition) {
		return {
			type: Action.UPDATE_CONDITION,
			value: condition
		};
	},
	updateSearchResult(searchResult) {
		return {
			type: Action.UPDATE_SEARCH_RESULT,
			value: searchResult
		}
	}
};

const Service = (dispatch) => ({
	async search(condition) {
		dispatch(ActionCreator.updateCondition(condition));
		const result = await search(condition);
		dispatch(ActionCreator.updateSearchResult(result));
	},


});

export default Service;