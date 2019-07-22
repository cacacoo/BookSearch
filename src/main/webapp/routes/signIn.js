import React from 'react';
import Avatar from '@material-ui/core/Avatar';
import Button from '@material-ui/core/Button';
import CssBaseline from '@material-ui/core/CssBaseline';
import TextField from '@material-ui/core/TextField';
import { Redirect} from "react-router-dom";
import Grid from '@material-ui/core/Grid';
import Box from '@material-ui/core/Box';
import LockOutlinedIcon from '@material-ui/icons/LockOutlined';
import Typography from '@material-ui/core/Typography';
import {withStyles} from '@material-ui/core/styles';
import Container from '@material-ui/core/Container';
import {connect} from "react-redux";
import Service from "../components/user/service";

const useStyles = theme => ({
    '@global': {
        body: {
            backgroundColor: theme.palette.common.white,
        },
    },
    paper: {
        marginTop: theme.spacing(8),
        display: 'flex',
        flexDirection: 'column',
        alignItems: 'center',
    },
    avatar: {
        margin: theme.spacing(1),
        backgroundColor: theme.palette.secondary.main,
    },
});

class SignIn extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            userId : '',
            pwd : ''
        };
    }

    join() {
        const { signUp } = this.props;
        const { userId, pwd } = this.state;
        signUp(userId, pwd);
    }

    login() {
        const { logIn } = this.props;
        const { userId, pwd } = this.state;
        logIn(userId, pwd);
    }

    render() {
        const {
            user,
            classes,
        } = this.props;

        const {
            userInfo,
            failMessage = '',
        } = user || {};

        const {
            userId = ''
        } = userInfo || {};

        if (userId) {
            return (<Redirect to="/book"/>);
        }

        return (
            <Container component="main" maxWidth="xs">
                <CssBaseline/>
                <div className={classes.paper}>
                    <Avatar className={classes.avatar}>
                        <LockOutlinedIcon/>
                    </Avatar>
                    <Typography component="h1" variant="h5">
                        Sign in
                    </Typography>

                    <div>
                        <Grid container
                              spacing={24}
                              direction="column"
                              justify="center"
                              alignItems="center"
                        >
                            <Grid item xs={12}>
                                <TextField
                                    id="email"
                                    type="email"
                                    label="email"
                                    onChange={(e) => {
                                        this.setState({userId: e.target.value})
                                    }}
                                />
                            </Grid>
                            <Grid item xs={12}>
                                <TextField
                                    id="password"
                                    label="Password"
                                    type="password"
                                    autoComplete="current-password"
                                    onChange={(e) => {
                                        this.setState({pwd: e.target.value})
                                    }}
                                />
                            </Grid>
                            <Grid item xs={12}>
                                <Button
                                    variant="outlined"
                                    color="primary"
                                    onClick={() => this.login()}
                                >log in</Button>
                                <Button
                                    variant="outlined"
                                    onClick={() => this.join()}
                                >sign in</Button>
                            </Grid>
                            <Grid item xs={12}>
                                <p>{failMessage}</p>
                            </Grid>
                        </Grid>
                    </div>
                </div>
                <Box mt={5}>
                </Box>
            </Container>
        );
    }
}

export default connect(state => state, Service)(withStyles(useStyles)(SignIn));