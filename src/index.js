import React from 'react';
import ReactDom from 'react-dom';
import Root from './main/webapp/Root'
import Store from './main/webapp/common/store';

ReactDom.render(<Root store={Store}/>, document.getElementById('root'));