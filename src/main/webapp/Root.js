import React from 'react';
import {BrowserRouter} from 'react-router-dom';
import App from './App';
import {Provider} from "react-redux";


const Root = ({store}) => (
    <Provider store={store}>
        <BrowserRouter>
            <App/>
        </BrowserRouter>
    </Provider>
);

export default Root;