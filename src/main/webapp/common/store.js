import BookReducer from '../components/book/reducer';
import UserReducer from '../components/user/reducer';
import { createStore, applyMiddleware, combineReducers } from 'redux';
import logger from 'redux-logger';
import ReduxThunk from 'redux-thunk';

const combinedReducers = combineReducers({
    book: BookReducer,
    user: UserReducer
});

const Store = createStore(combinedReducers, applyMiddleware(logger,ReduxThunk ));

export default Store;
