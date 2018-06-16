/*
 * Copyright (c) 2018 - 2018, Chris Kelly, all rights reserved.
 *
 * This software is licensed under under GPL-3.0-only or GPL-3.0-or-later, https://opensource.org/licenses/GPL-3.0
 */

package io.cap.work;

/**
 * Basic operation with no init or setup, save context
 * so that it is available within run operations.
 */
public class BasicOperation extends AbstractOperation
{

    @Override
    public void init()
    {
        //Do nothing
    }

    @Override
    public Output run(Input input )
    {
        return new Output( input );
    }

    @Override
    public void cleanup()
    {
        //Do nothing
    }
}
