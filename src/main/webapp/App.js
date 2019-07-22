import React from 'react';
import { Route, Switch} from 'react-router-dom';
import { SignIn, SignUp, BookContainer } from './routes';

export default class App extends React.Component {
    render() {
        return (
            <div>
                <Switch>
                    <Route exact path="/" component={SignIn}/>
                    <Route path="/signUp" component={SignUp}/>
                    <Route path="/book" component={BookContainer}/>
                </Switch>
            </div>
        );
    }
}
