import React from 'react';
import ReactDom from 'react-dom';
import { Provider } from 'react-redux'
import BookContainer from './main/webapp/components/book/container';
import Store from './main/webapp/components/book/store';

const renderApp = () => {
	ReactDom.render(
		<Provider store={Store}>
			<BookContainer />
		</Provider>,
		document.getElementById("root")
	);
};

Store.subscribe(renderApp);
renderApp();