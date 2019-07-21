import Reducer from './reducer';
import { createStore, applyMiddleware } from 'redux';
import logger from 'redux-logger';

const Store = createStore(Reducer, applyMiddleware(logger));

export default Store;
