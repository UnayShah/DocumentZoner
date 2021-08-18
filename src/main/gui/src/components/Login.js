import React, { Component } from "react";
import { makeStyles, withStyles } from '@material-ui/core/styles';
import { Button, Container, TextField, Avatar, Checkbox, Grid, Link } from '@material-ui/core';
import FormControlLabel from '@material-ui/core/FormControlLabel';
import Logo from '../resources/Logo.svg'

const useStyles = makeStyles((theme) => ({
    paper: {
        marginTop: theme.spacing(8),
        display: 'flex',
        flexDirection: 'column',
        alignItems: 'center',
    },
}));
class Login extends Component {
    render() {
        const {classes} = this.props;
        return (
            <Container component="main" maxWidth="xs">
                <div className={classes.paper}>

                    Sign In
                    {/* <img src={Logo} alt="doczoner"/> */}
                    <Avatar variant="rounded" src={Logo}>
                    </Avatar>
                    {/* <SvgIcon component={Logo} /> */}
                    <form>
                        <TextField variant="outlined" required id="email" name="email" label="Email Address" autoComplete="email" autoFocus fullWidth />
                        <TextField variant="outlined" required id="password" name="password" label="Password" autoComplete="current-password" autoFocus fullWidth type="password" />
                        <FormControlLabel
                            control={<Checkbox value="remember" color="primary" />}
                            label="Remember me" />
                        <Button variant='contained' color='primary' id="login" fullWidth>Login</Button>
                        <Grid container>
                            <Grid item xs>
                                <Link href="" variant="body2">
                                    Forgot password?
                                </Link>
                            </Grid>
                            <Grid item>
                                <Link href="" variant="body2">
                                    {"Don't have an account? Sign Up"}
                                </Link>
                            </Grid>
                        </Grid>
                        {/* <Button variant='contained' color='primary' id="signup">Sign Up</Button> */}
                    </form>
                </div>
            </Container>
        )
    }
}

export default withStyles(useStyles)(Login);