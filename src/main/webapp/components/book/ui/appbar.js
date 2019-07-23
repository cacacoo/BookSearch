import React from 'react';
import PropTypes from 'prop-types';
import AppBar from '@material-ui/core/AppBar';
import Toolbar from '@material-ui/core/Toolbar';
import Typography from '@material-ui/core/Typography';
import InputBase from '@material-ui/core/InputBase';
import {fade, withStyles} from '@material-ui/core/styles';
import SearchIcon from '@material-ui/icons/Search';

const useStyles = (theme) => ({
    title: {
        flexGrow: 1,
        display: 'none',
        [theme.breakpoints.up('sm')]: {
            display: 'block',
        },
    },
    search: {
        position: 'relative',
        borderRadius: theme.shape.borderRadius,
        backgroundColor: fade(theme.palette.common.white, 0.15),
        '&:hover': {
            backgroundColor: fade(theme.palette.common.white, 0.25),
        },
        marginLeft: 0,
        width: '100%',
        [theme.breakpoints.up('sm')]: {
            marginLeft: theme.spacing(1),
            width: 'auto',
        },
    },
    searchIcon: {
        width: theme.spacing(7),
        height: '100%',
        position: 'absolute',
        pointerEvents: 'none',
        display: 'flex',
        alignItems: 'center',
        justifyContent: 'center',
    },
    inputRoot: {
        color: 'inherit'
    },
    inputInput: {
        padding: theme.spacing(1, 1, 1, 7),
        transition: theme.transitions.create('width'),
        width: '100%',
        [theme.breakpoints.up('sm')]: {
            width: 120,
            '&:focus': {
                width: 200,
            },
        },
    },
});

const menus = [
    'logOut'
];

class BookAppBar extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            keyword:'',
            menu: ''
        };
    }

    keyPress(e){
        if(e.keyCode === 13){
            this.props.searchKeyword(e.target.value);
        }
    }

    handleChange(e){
        this.setState({keyword: e.target.value})
    }

    render() {
        const { classes, userInfo } = this.props;
        const { userId = ''} = userInfo || {};

        return (
            <div>
                <AppBar position="absolute">
                    <Toolbar>
                        <Typography className={classes.title} variant="h6" noWrap>
                            {userId} 님
                        </Typography>
                        <Typography>
                            Book Search
                        </Typography>
                        <div className={classes.search}>
                            <div className={classes.searchIcon}>
                                <SearchIcon/>
                            </div>
                            <InputBase
                                placeholder="Press Enter Key"
                                classes={{
                                    root: classes.inputRoot,
                                    input: classes.inputInput,
                                }}
                                inputProps={{'aria-label': 'Search'}}
                                value={this.state.keyword}
                                onChange={e => this.handleChange(e)}
                                onKeyDown={e => this.keyPress(e)}
                            />
                        </div>
                    </Toolbar>
                </AppBar>
            </div>
        );
    }
}

BookAppBar.propTypes = {
    classes: PropTypes.object.isRequired,
    searchKeyword: PropTypes.func
};

export default withStyles(useStyles)(BookAppBar)