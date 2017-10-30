package com.ran.learn.lession2;

/**
 * Created by zhangran on 2017/10/30.
 */
@FunctionalInterface
public interface DiscardPolicy {
    void discard() throws DiscardException;
}
